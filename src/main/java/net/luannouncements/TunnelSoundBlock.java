package net.luannouncements;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

/**
 * Plays the train tunnel sound on a loop, forever, from the moment it is placed.
 * Same idea as the "See it Say it Sorted" block in the MTR London Underground Addon.
 */
public class TunnelSoundBlock extends Block {
    // The sound is 14.65 seconds long = about 293 game ticks (20 ticks per second).
    // Change this number if you replace the sound with a different length.
    public static final int LOOP_TICKS = 293;

    // 1.0 = audible up to about 16 blocks. 2.0 = about 32 blocks, 4.0 = about 64 blocks.
    public static final float VOLUME = 1.0f;

    public TunnelSoundBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient && !oldState.isOf(state.getBlock())) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.playSound(null, pos, TunnelSoundMod.TUNNEL_SOUND_EVENT, SoundCategory.AMBIENT, VOLUME, 1.0f);
        world.scheduleBlockTick(pos, this, LOOP_TICKS);
    }
}
