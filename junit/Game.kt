class Game {

    private val redTeam = mutableListOf<String>()
    private val blueTeam = mutableListOf<String>()
    private var redGoals = 0
    private var blueGoals = 0
    private var gameStarted = false

    fun start() {
        if(!gameStarted && teamsSizesEquals()) {
            gameStarted = true
            redGoals = 0
            blueGoals = 0
            //do and allow for some actions
        }
    }

    fun stop() {
        if(gameStarted) {
            gameStarted = false
            //do some other actions
        }
    }

    fun clearTeams() {
        redTeam.clear()
        blueTeam.clear()
    }

    fun addPlayer(team: Team, player: String): Boolean {
        if(allowToAddPlayer(player)) {
            when(team) {
                Team.RED -> { redTeam.add(player) }
                Team.BLUE -> { blueTeam.add(player) }
            }
            return true
        }
        else return false
    }

    fun removePlayer(player: String): Boolean {
        if(allowToRemovePlayer(player)) {
            if(redTeam.contains(player)) redTeam.remove(player)
            else blueTeam.remove(player)
            return true
        }
        else return false
    }

    fun goal(team: Team) {
        when(team) {
            Team.RED -> { redGoals++ }
            Team.BLUE -> { blueGoals++ }
        }
    }

    fun getScore(): String {
        return "RED $redGoals:$blueGoals BLUE"
    }

    fun getRedTeam(): List<String> {
        return redTeam
    }

    fun getBlueTeam(): List<String> {
        return blueTeam
    }

    fun hasStarted(): Boolean {
        return gameStarted
    }

    private fun allowToAddPlayer(player: String): Boolean {
        return (!gameStarted && !redTeam.contains(player) && !blueTeam.contains(player))
    }

    private fun allowToRemovePlayer(player: String): Boolean {
        return (!gameStarted && (redTeam.contains(player) || blueTeam.contains(player)))
    }

    private fun teamsSizesEquals(): Boolean {
        return redTeam.size != 0 && blueTeam.size != 0 && redTeam.size.equals(blueTeam.size)
    }

    enum class Team {
        RED, BLUE;
    }
}