def job = Hudson.instance.items.find{ it.name == 'xxxxx' }

def totalDurationInSeconds = (int) (job.builds*.duration.sum() / 1000 / 60)
def avgDurationInSeconds = totalDurationInSeconds / job.builds.size()
println avgDurationInSeconds
