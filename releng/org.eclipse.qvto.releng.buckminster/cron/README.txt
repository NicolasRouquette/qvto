The crontab.txt file contains the commands that must be daily executed (via cron) to promote our last successful build.

This is a release engineer task. To configure that:
1. Connect to build.eclipse.org via an ssh connection.
2. Create a "logs" folder in your home directory (if you haven't done it, yet).
3. Type "crontab -e" and copy-paste the contents of the aforementioned file.

A new milestone build may be explitly promoted by:

logon to build.eclipse.org
ant -f /shared/jobs/buckminster-mmt-qvto-3.3/lastSuccessful/archive/publishroot/publisher.ant -Dbuild.archives=/shared/jobs/buckminster-mmt-qvto-3.3/lastSuccessful/archive &> logs/mmt-qvto-publishing-3.3.log 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/mmt/qvto/updates/milestones/3.3.0
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201210020848

The Kepler aggregator is configured by GIT\org.eclipse.simrel.build\mmt-qvto.b3aggrcon to use the milestones repo
so no further action is needed there.