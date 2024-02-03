def gv

pipeline {

    agent any

    stages {
        stage("init"){
            steps{
                script{
                    echo "initializing"
                }
            }
        }

        stage("build jar"){
            steps{
                script{
                    echo "building jar"
                }
            }
        }

        stage("build image"){
            steps{
                script{
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t neileverette/demo-app:jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push neileverette/demo-app:jma-2.0'
                    }
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    echo "deploy"
                }
            }
        }
    }
}
