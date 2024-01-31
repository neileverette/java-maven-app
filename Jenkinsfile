pipeline {
    tools {

        }
    agent any

    stages {
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
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsID: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER' )]){
                        sh 'docker build -t neileverette/demo-app: jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push neileverette/demo-app: jma-2.0'
                    }
                }
            }
        }
        stage("test"){
            steps{
                script{
                    echo "test"
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
