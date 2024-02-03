def gv

pipeline {

    agent any

    stages {
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar"){
            steps{
                script{
                    echo "building jar"
                    sh 'mvn package'
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
