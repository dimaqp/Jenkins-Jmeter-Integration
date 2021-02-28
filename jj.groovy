#!groovy
pipeline {
    agent any
    stages {
//        stage('Prepare output folder ') {
//            steps {
//                del / q "C:\jMeter-Jenkins\apache-jmeter-5.2.1\bin\Execution_resultsTC1\*"
//                FOR / D % % p IN("C:\jMeter-Jenkins\apache-jmeter-5.2.1\bin\Execution_resultsTC1\*.*") DO rmdir "%%p" / s / q
//            }
//        }
        stage('TC_01') {
            steps {
                echo 'This stage will be executed first.'
                sh(script: "date -u")
                build(job: 'TC1_Select a product from category')
            }
        }
//        stage('Parallel Stage') {
//            parallel {
//                stage('TC_02') {
//                    steps {
//                        echo "TC_02"
//                        sh(script: "date -u")
//                        build(job: 'TC2_Write a review to a product')
//                    }
//                }
//                stage('TC_03'){
//                    steps{
//                        echo "TC_03"
//                        sh(script: "date -u")
//                        build(job: 'TC3_Add and remove a product from Shopping Cart')
//                    }
//                }
//            }
//        }
    }
}
