#!groovy
pipeline {
    agent any
    stages {
        stage('Test Case 1') {
            steps {
                bat """
                     del /q "C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\Execution_resultsTC1\\*"
                     FOR /D %%p IN (C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\Execution_resultsTC1\\*.*) DO rmdir "%%p" /s /q
                     
                     C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\jmeter -Jjmeter.save.saveservice.subresults=false  -Jthreads=%threads% -Jrampup=%rampup% -Jloopcount=%loopcount% -Jduration=%duration% -n -t C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\opencarton.jmx -l C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\Execution_resultsTC1\\TestData.jtl -e -o C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\Execution_resultsTC1\\HTML-Report
                     mkdir C:\\Program Files (x86)\\Jenkins\\jobs\\TC1_Select a product from category\\%BUILD_NUMBER%\\archive\\HTML-report\\
                     xcopy C:\\jMeter-Jenkins\\apache-jmeter-5.2.1\\bin\\Execution_resultsTC1\\HTML-Report\\ C:\\Program Files (x86)\\Jenkins\\jobs\\TC1_Select a product from category\\builds\\%BUILD_NUMBER%\\archive\\HTML-report /E /H /C /I
                    """
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
