pipeline {
    agent any

    tools {
            maven 'MAVEN_HOME'
    }
    triggers {
            githubPush()
        }
environment {
        LC_ALL = 'en_US.UTF-8'
        LANG    = 'en_US.UTF-8'
        LANGUAGE = 'en_US.UTF-8'
        EMAIL_TO = 'auslonceva@ya.ru'
    }
    parameters {
            string(name: 'GIT_URL', defaultValue: 'https://github.com/AlenaUslontseva/otus_lesson25.git', description: 'The target git url')
            string(name: 'GIT_BRANCH', defaultValue: 'master', description: 'The target git branch')
            string(name: 'EMAIL_NOTIFICATION', defaultValue: 'auslonceva@ya.ru', description: 'default email')
    }

    stages {
        stage('Pull from GitHub') {
            steps {
                git ([
                    url: "${params.GIT_URL}",
                    branch: "${params.GIT_BRANCH}"
                    ])
            }
        }
        stage('Run maven clean test') {
            steps {
                bat 'mvn clean test -Dfile.encoding=UTF8'
            }
        }
        stage('Backup and Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            }
            post {
                always {
                    script {
                    // Узнаем ветку репозитория
                                          def branch = bat(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD\n').trim().tokenize().last()
                                          println("branch= " + branch)
                    // Достаем информацию по тестам из junit репорта
                                          def summary = junit testResults: '**/target/surefire-reports/*.xml'
                                          println("summary generated")
                    // Текст оповещения
                                          def message = "${currentBuild.currentResult}: Job ${env.JOB_NAME}, build ${env.BUILD_NUMBER}, branch ${branch}\nTest Summary - ${summary.totalCount}, Failures: ${summary.failCount}, Skipped: ${summary.skipCount}, Passed: ${summary.passCount}\nMore info at: ${env.BUILD_URL}"
                                          if (currentBuild.currentResult == 'SUCCESS') {
                                          step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: "auslonceva@ya.ru", sendToIndividuals: true])
                                          } else {
                                         step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: "auslonceva@ya.ru", sendToIndividuals: true])
                                                 }
                    // Формирование отчета allure
                        allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                        ])

                        sendNotification()
                    }
                }
            }
        }
    }
 }

 def sendNotification() {
    def summary = junit testResults: '**/target/surefire-reports/*.xml'
    def branch = bat(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD\n').trim().tokenize().last()
    def emailMessage = "${currentBuild.currentResult}: Job '${env.JOB_NAME}', Build ${env.BUILD_NUMBER}, Branch ${branch}. \nPassed time: ${currentBuild.durationString}. \n\nTESTS:\nTotal = ${summary.totalCount},\nFailures = ${summary.failCount},\nSkipped = ${summary.skipCount},\nPassed = ${summary.passCount} \n\nMore info at: ${env.BUILD_URL}"
emaitext (
        subject: "Jenkins Report",
        body: emailMessage,
        to: "auslonceva@ya.ru",
        from: "jenkins@code-maven.com"
    )
    def colorCode = '#FF0000'
    if (currentBuild.currentResult == 'SUCCESS') {
        colorCode = '#00FF00'
    }

    def slackMessage = "${currentBuild.currentResult}: Job '${env.JOB_NAME}', Build ${env.BUILD_NUMBER}. \nPassed time: ${currentBuild.durationString}. \n\nTESTS:\nTotal = ${summary.totalCount},\nFailures = ${summary.failCount},\nSkipped = ${summary.skipCount},\nPassed = ${summary.passCount} \n\nMore info at: ${env.BUILD_URL}"

    slackSend(color: colorCode, message: slackMessage)
 }