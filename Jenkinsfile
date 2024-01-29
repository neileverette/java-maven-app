def gv

pipeline {

    agent any

    stages {

        stage("init"){
            steps{
                echo "Initialize"
            }
        }
        stage("build"){
            steps{
                echo "Build"

               // Step 1: Build the Docker image
               sh 'docker build -t neileverette/js-app:1.3 .'

               // Step 2: Log in to Docker Hub (replace $USERNAME and $PASSWORD with your actual credentials)
               sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'

               // Step 3: Push the Docker image to Docker Hub
               sh 'docker push neileverette/js-app:1.3'
            }
        }
        stage("test"){
            steps{
                echo "Testing"
            }
        }
        stage("deploy"){
            steps{
                echo "Deploy"
            }
        }
    }
    post {
     success {}

    }

}
