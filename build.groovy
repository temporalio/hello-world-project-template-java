pipeline {
agent any
options {
    buildDiscarder(logRotator(numToKeepStr:'2' , artifactNumToKeepStr: '2'))
    timestamps()
    }
  stages {
    stage('CheckOut') {
      steps {
        echo 'Checking out project from Bitbucket....'
          git branch: 'main', url: 'https://github.com/vamsi8977/gradle_sample.git'
      }
    }
stage('build') {
      steps {
        ansiColor('xterm') {
          echo 'Gradle Build....'
           sh "./gradlew clean build"
        }
      }
    }
stage('SonarQube') {
    steps {
        withSonarQubeEnv('SonarQube') {
            sh "./gradlew sonar"
        }
    }
}
  }//end stages
post {
      success {
          archiveArtifacts artifacts: "gradle/build/libs/*.jar"
      }
      failure {
          echo "The build failed."
      }
      cleanup{
        deleteDir()
      }
    }
}