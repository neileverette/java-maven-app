pipeline {

    agent any

    stages {
        stage("build") {
            steps {
                echo 'building the applicaiton'
            }
        }
        stage("test") {
            steps {
                echo 'testing the applicaiton'           
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the applicaiton'
                
            }
        }

        stage("cleanup") {
            steps {
                echo 'cleaning up the applicaiton'
                
            }
        }
    }
    post {

        always {
            echo 'I always show up'
        }

        failure {
            echo 'This failed'

        }

    }
}
