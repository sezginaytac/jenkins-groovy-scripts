def job = Hudson.instance.items.find{ it.name == 'xxxxx' }

// with the spread-dot operator (*.) 
def totalDurationInSeconds = (int) (job.builds*.duration.sum() / 1000 / 60)
def avgDurationInSeconds = totalDurationInSeconds / job.builds.size()
println avgDurationInSeconds

// with the inject() method
def totalDurationInSeconds2 = (int) (job.builds.inject(0){result, b -> result += b.duration} / 1000 / 60)
def avgDurationInSeconds2 = totalDurationInSeconds2 / job.builds.size()
println avgDurationInSeconds2
