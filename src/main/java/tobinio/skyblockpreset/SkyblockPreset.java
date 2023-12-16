package tobinio.skyblockpreset;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.WorldPresets;
import net.minecraft.world.gen.structure.Structure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.minecraft.server.command.CommandManager.literal;


public class SkyblockPreset implements ModInitializer {


    public static final Logger LOGGER = LoggerFactory.getLogger("Skyblock Preset");
    public static final List<String> ALLOWED_STRUCTURES = new ArrayList<>(List.of("minecraft:stronghold", "minecraft:end_city", "minecraft:fortress"));

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Registry.register(
                Registries.CHUNK_GENERATOR,
                new Identifier("skyblock-preset", "skyblock"),
                SkyBlockChunkGenerator.CODEC);
    }
}
