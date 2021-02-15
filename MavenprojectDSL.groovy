job('My 1st job via DSL plugin') {
    description("this is my first job to test the 1st DSL groovy script code file to pacakge the project")
    scm {
        github("https://github.com/mani-devops-eng/time-tracker.git")
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean build package','time-tracker/pom.xml')
    }
    publishers {
        archiveArtifacts('**/*.war')
    }
}
