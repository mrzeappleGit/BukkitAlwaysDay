# AlwaysDay Plugin

## Overview
**AlwaysDay** is a Minecraft plugin that ensures it is always daytime in the configured world(s) and provides fine control over the weather and time settings. It includes commands to manage the time, weather, and players, and supports automatic adjustments to these aspects of the game.

## Features
- Automatically changes the time to day when it starts to turn night.
- Controls weather to maintain a consistent environment.
- Configurable per-world settings.
- Ability to specify which players trigger the plugin actions.
- Customizable via commands and configuration.

## Installation

1. Download the latest version of the plugin jar file.
2. Place the plugin file in the `plugins` folder of your Minecraft server.
3. Restart or reload the server.

## Commands

| Command              | Description                                               | Permission            |
| -------------------- | --------------------------------------------------------- | --------------------- |
| `/adreload`          | Reloads the configuration file.                           | `alwaysday.reload`    |
| `/adadd <player>`    | Adds a player to the list of monitored players.            | `alwaysday.add`       |
| `/adremove <player>` | Removes a player from the monitored list.                 | `alwaysday.remove`    |
| `/adworld <world>`   | Sets the world for which the plugin should function.       | `alwaysday.world`     |
| `/adweather <on/off>`| Enables or disables weather control.                      | `alwaysday.weather`   |
| `/adtime <on/off>`   | Enables or disables time control.                         | `alwaysday.time`      |
| `/adanyone <on/off>` | Enables triggering for any player, not just specific ones.| `alwaysday.anyone`    |
| `/adweathertype <type>` | Sets the weather type (clear, rain, thunder).           | `alwaysday.weather`   |
| `/adtimechange <ticks>` | Sets the time of day change interval in ticks.          | `alwaysday.time`      |

## Permissions
The plugin uses the following permissions for control:

- `alwaysday.reload` – Grants permission to reload the plugin configuration.
- `alwaysday.add` – Grants permission to add players to the monitored list.
- `alwaysday.remove` – Grants permission to remove players from the monitored list.
- `alwaysday.world` – Grants permission to change the target world for the plugin.
- `alwaysday.weather` – Grants permission to control the weather.
- `alwaysday.time` – Grants permission to control the time.
- `alwaysday.anyone` – Grants permission to toggle whether any player can trigger the actions.
  
## Configuration

You can configure various options by modifying the `config.yml` file:

```yaml
# The world in which AlwaysDay operates
world: "world"

# Enable weather control (true or false)
weather_control: true

# Set the weather type (clear, rain, thunder)
weather_type: "clear"

# Enable time control (true or false)
time_control: true

# Time to change the day (in ticks)
time_change: 6000

# The set time when night starts, in ticks (0 = dawn, 6000 = noon, 18000 = midnight)
time_set: 1000

# Allow triggering for any player, or only specified players
when_anyone: true

# List of specific players to trigger the plugin
select_player:
  - "Player1"
  - "Player2"
