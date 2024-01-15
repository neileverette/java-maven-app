pipeline {
    agent any
    stages {
        stage("build") {
            steps {
                echo 'Building the applicaiton'
            }
        }
        stage("test") {
            steps {
                echo 'Testing the applicaiton'           
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
