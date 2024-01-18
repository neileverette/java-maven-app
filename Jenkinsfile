#!User/bin/env groovy
@Library('jenkins-shared-library')
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

            steps {
                script{
                    buildJar()
                }
            }
        }
        stage("build image") {

            steps {
                script{
                    buildImage()
                }
            }
        }

        stage("deploy") {

            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}
