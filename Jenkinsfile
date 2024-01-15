pipeline {
    agent any
    tools {
        maven 'maven-version-3.9.6'
    }
    stages {
        stage("build jar") {
            steps {
                echo 'Building the applicaiton with a jar file'
                sh 'mvn package'
            }
        }
        stage("build image") {
            steps {
                echo 'Building the application image file'
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]){
                    sh 'docker build -t docker neileverette/demo-app:jma-2.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push neileverette/demo-app:jma-2.0'
                }
            }
        }

        stage("deploy") {
            steps {
                echo 'Deploying the applicaiton'
            }
        }
    }
    post {
        always {
            echo 'Post always shows up'
        }
        failure {
            echo 'Show this if the build fails'

        }

    }
}
