# RoPaSci (Rock, Paper, Scissor CLI)

A Rock-Paper-Scissor CLI Game

## Getting Started
```
mvn clean install
```

```
java -jar target/artifact
```
## AVAILABLE COMMANDS
```
Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Ropasci CLI
        reset-game: Reset the game to default values
        set-playernames: Set name of the players
        set-strategy: Set name of the players - default value is random
        start-game: Start the game with n rounds - default value is one
```

```
NAME
	reset-game - Reset the game to default values

SYNOPSYS
	reset-game 
```

```
NAME
	set-playernames - Set name of the players

SYNOPSYS
	set-playernames [[-1] string]  [[-2] string]  

OPTIONS
	-1 or --first  string
		"-1", "--first" for the first player -  "-2", "--second"  for the second player
		[Optional, default = Player1]

	-2 or --second  string
		
		[Optional, default = Player2]
```

```
NAME
	set-strategy - Set name of the players - default value is random

SYNOPSYS
	set-strategy [[-1] string]  [[-2] string]  

OPTIONS
	-1 or --first  string
		"-1", "--first" for the first player -  "-2", "--second"  for the second player
		[Optional, default = random]

	-2 or --second  string
		
		[Optional, default = random]
```

```
NAME
	start-game - Start the game with n rounds - default value is one

SYNOPSYS
	start-game [[--rounds] int]  

OPTIONS
	--rounds  int
		
		[Optional, default = 1]

```

```
NAME
	reset-game - Reset the game to default values

SYNOPSYS
	reset-game 
```


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Jesko Steinberg** 


