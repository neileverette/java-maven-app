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

                docker build -t neileverette/js-app:1.3 .
                echo $PASSWORD | docker login -u $USERNAME --password-stdin
                docker push neileverette/js-app:1.3
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
