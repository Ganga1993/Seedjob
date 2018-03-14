pipelineJob('test-pg-job') {
  description('test pg ')
  logRotator(5,5)
  parameters {
    choiceParam('action',['Launch','Destroy'],'')
	nonStoredPasswordParam('myParameterName', 'mydescription')
  }
  configure {
    it / 'properties' / 'hudson.model.ParametersDefinitionProperty' / 'parameterDefinitions' << 'hudson.model.PasswordParameterDefinition' {
            name('master_password')
            description('password for rds database')
        }
  }
  definition {
    cps {
        script(readFileFromWorkspace('pipeline/test.groovy'))
        sandbox()
    }
  }

}