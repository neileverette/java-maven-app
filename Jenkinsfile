def gv

pipeline {

    agent any

    stages {

        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
                echo "Initialize"
            }
        }
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
            }
        }
        stage("test"){
            steps{
                script{
                    gv.testApp()
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
