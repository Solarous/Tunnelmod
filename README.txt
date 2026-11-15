LU Announcements - Train Tunnel Sound (Fabric 1.20.1)
=====================================================
Adds one block, "Train Tunnel Sound" (creative inventory > Functional Blocks,
or /give @s luannouncements:train_tunnel_sound).
Once placed it plays the train tunnel sound on a loop forever, the same way the
"See it Say it Sorted" block does in the MTR London Underground Addon.

Build it (needs JDK 17 and Gradle 8.x):
    gradle build
The finished mod is  build/libs/luannouncements-tunnel-sound-1.0.0.jar
Put it in your mods folder with Fabric API.

Tweaks (src/main/java/net/luannouncements/TunnelSoundBlock.java):
    LOOP_TICKS  - length of the sound in ticks (seconds x 20). Currently 293.
    VOLUME      - 1.0 is about 16 blocks range; raise it to hear it from further.

Credit: the block texture is copied from the MTR London Underground Addon
(MIT licence, t1NbLu3).

No Gradle installed? Build it online for free instead:
 1. Make a free GitHub account and create a new repository.
 2. Upload everything in this folder (including the hidden .github folder).
 3. Open the repository's Actions tab, wait for "build" to finish (about 3 minutes).
 4. Open that run and download the "luannouncements-tunnel-sound" artifact. The .jar is inside.
