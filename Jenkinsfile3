pipeline{
    agent any
    stages{
        stage('Build Application') {
            steps{
                sh 'mvn clean package'
                //sh 'mvn --f time-tracker/pom.xml clean package'
                //buildInfo = rtMaven.run pom: 'time-tracker/pom.xml', goals: 'clean package'
            }
            post{
                success{
                    echo 'Now Archiving the Artifacts....'
                    archiveArtifacts artifacts: '**/*.war'
                }
            }
        }
        stage('Deploy in Staging Environment'){
            steps{
                build job: 'Deploy_Application_Stag Area'
            }
        }
        stage('Deploy to Production'){
            steps{
                timeout(time:5, unit:'DAYS'){
                    input message:'Approve PRODUCTION Deployment?'
                }
                build job: 'Deploy_Application_Production'
            }
        }
    }
}