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
    echo "Deploying the application"
    echo 'Another change'
}

def cleanApp(){
    echo "Cleaning things up"
}

return this