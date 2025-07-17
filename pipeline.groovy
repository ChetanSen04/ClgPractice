def CODE_CHANGES = getGitChanges()

pipeline {
    agent any
    stages {
        stage("build") {
            when {
                allOf {
                    branch 'main'
                    expression { CODE_CHANGES == true }
                }
            }
            steps {
                echo "building application"
            }
        }

        stage("test") {
            when {
                branch 'development'
            }
            steps {
                echo 'testing app'
            }
        }

        stage("deploy") {
            steps {
                echo 'deploying app'
            }
        }
    }
}
