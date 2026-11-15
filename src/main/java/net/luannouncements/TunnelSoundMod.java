package net.luannouncements;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class TunnelSoundMod implements ModInitializer {
    public static final String MOD_ID = "luannouncements";

    public static final Identifier TUNNEL_SOUND_ID = new Identifier(MOD_ID, "train_tunnel_sound");
    public static final SoundEvent TUNNEL_SOUND_EVENT = SoundEvent.of(TUNNEL_SOUND_ID);

    public static final Block TUNNEL_SOUND_BLOCK =
            new TunnelSoundBlock(AbstractBlock.Settings.create().strength(1.0f));

    @Override
    public void onInitialize() {
        Registry.register(Registries.SOUND_EVENT, TUNNEL_SOUND_ID, TUNNEL_SOUND_EVENT);
        Registry.register(Registries.BLOCK, TUNNEL_SOUND_ID, TUNNEL_SOUND_BLOCK);
        Item item = Registry.register(Registries.ITEM, TUNNEL_SOUND_ID,
                new BlockItem(TUNNEL_SOUND_BLOCK, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register(entries -> entries.add(item));
    }
}
