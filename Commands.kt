package converter

enum class Commands(val string: String) {
    FROM("/from"), TO("/to"), EXIT("/exit");

    companion object {
        fun getCommand(input: String): Commands {
            for (command in Commands.values()) {
                if (command.string == input.lowercase()) {
                    return command
                }
            }
            throw RuntimeException("Unknown command $input")
        }
    }
}