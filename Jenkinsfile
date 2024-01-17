def gv

pipeline {
    agent any
    tools {
        maven 'maven-version-3.9.6'
    }
    stages {
        stage("init"){
            steps{
                script{
                    echo "Executing branch pipeline for $BRANCH_NAME"
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script{
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            steps {
                script{
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
