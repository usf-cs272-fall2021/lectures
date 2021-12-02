JDBC
=================================================

These demos illustrate basic concepts related to embedded Jetty and database connections in Java.

## Configuration ##

Modify `database.properties` with your MariaDB username and password. ~~If you
are connecting from on-campus, set `hostname=sql.cs.usfca.edu` in the
properties file.~~

If you are connecting off-campus, set `hostname=localhost:3307` in the
properties file and create an SSH tunnel to forward anything sent to your
port 3307 to our on-campus MariaDB database server port 3306 using this command:

```
ssh username@stargate.cs.usfca.edu -L 3307:sql.cs.usfca.edu:3306
```

...where `username` is your CS username. You will be prompted for your CS password.

If you are a Mac user, you can create a `tunnel.command` file with the SSH command you should use and give the file execute privileges. Then, you should be able to double-click the file to run the command.

If you are a Windows user, you can use Windows Terminal to setup the tunnel (or port forwarding) or use a program like Putty. (Search for "Putty Port Forwarding" to find several guides.)

## Official Resources ##

The following official [Java Tutorials](http://docs.oracle.com/javase/tutorial/index.html) may be useful:

- [The Java Tutorials – Lesson: JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

## Security Notes ##

Nothing we do regarding security will be effective unless we also use encrypted communication between the client browser and the web server. For this, you should be using HTTPS instead of HTTP.

Unless you are a security expert, I always recommend you use a package designed by security professionals for handling sensitive information (like username and passwords). However, there are some best practices guides out there. See the [OWASP Password Storage Cheat Sheet](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Password_Storage_Cheat_Sheet.md) for an example.
