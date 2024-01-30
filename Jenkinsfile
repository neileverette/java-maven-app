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
                echo "---------------------------"
                echo "Building ${BRANCH_NAME}"
                echo "---------------------------"

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
}
