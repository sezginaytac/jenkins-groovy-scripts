import hudson.model.*

//def jobName = System.getenv()['job']
def jobName = 'my-job'
println Hudson.instance.getItem(jobName).configFile.asString()
