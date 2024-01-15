def buildJar() {
    echo 'building the jar file'
    sh 'mvn package'
}

def buildImage() {
    echo 'building the image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]){
        sh 'docker build -t neileverette/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push neileverette/demo-app:jma-2.0'
    }
}

def deployApp() {
    echo 'deploying the app'
}

return this