def buildJar(){
    echo "Building the application"
    sh 'mvn package'
}

def buildImage(){
    echo "building image"
    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t neileverette/demo-app:jma-2.1 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push neileverette/demo-app:jma-2.1'
        }
}

def deployApp(){
    echo '-------------------------'  
    echo 'deploying the app to EC2' 
    echo '-------------------------'   
    //def dockerCMD = 'docker run -p 3080:3080 -d neileverette/demo-app:jma-2.1'
    def dockerComposeCmd = 'docker-compose -f docker-compose.yaml up --detach'
    sshagent(['ec2-server-key']) {
        sh 'scp docker-compose.yaml ec2-user@18.222.122.196:/home/ec2-user'
        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.222.122.196 ${dockerComposeCMD}"
}

}

def cleanApp(){
    echo "Cleaning things up"
}

return this