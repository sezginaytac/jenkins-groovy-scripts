import hudson.model.*
import java.text.SimpleDateFormat

def sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

// config's lastModified for a given job 
//def lastModified = Hudson.instance.getItem('my-job-name').configFile.file.lastModified()
//println sdf.format(lastModified)

def oneDayInMillis = 24 * 60 * 60 * 1000
def nDaysBefore = new Date().time - 7 * oneDayInMillis

for(j in Hudson.instance.items) {
  lastModified = j.configFile.file.lastModified()
  if (lastModified >= nDaysBefore) {
    lastModifiedStr = sdf.format( lastModified )
    println( "$j.name - $lastModifiedStr" )
  }
}
