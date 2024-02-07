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
    
    // define docker compose command 
    //def dockerComposeCmd = 'docker-compose -f docker-compose.yaml up --detach'
    
    // define script to run on server
    def shellCmd = 'bash ./server-commands.sh'
    
    sshagent(['ec2-server-key']) {
        
        // copy server script file to serrver
        sh 'scp server-commands.sh ec2-user@18.222.122.196:/home/ec2-user'
        
        // copy docker compose file to server
        sh 'scp docker-compose.yaml ec2-user@18.222.122.196:/home/ec2-user'

        // run shell commond on server
        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.222.122.196 ${shellCmd}"
        
        // run docker compose file on server
        //sh "ssh -o StrictHostKeyChecking=no ec2-user@18.222.122.196 ${dockerComposeCmd}"
}

}

def cleanApp(){
    echo "Cleaning things up"
}

return this