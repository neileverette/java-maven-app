def buildJar(){
    echo "Building the application"
    sh 'mvn package'
}

def testApp(){
    echo "Testing the application"
}

def deployApp(){
    echo "Deploying the application"
}

def cleanApp(){
    echo "Cleaning things up"
}

return this