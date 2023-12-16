package tobinio.skyblockpreset.mixin;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.level.ServerWorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tobinio.skyblockpreset.SkyblockPreset;

import java.util.Optional;

@Mixin (MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject (method = "setupSpawn", at = @At (value = "TAIL"))
    private static void setupSpawn(ServerWorld world, ServerWorldProperties worldProperties, boolean bonusChest,
            boolean debugWorld, CallbackInfo ci) {

        Identifier structureIdentifier = new Identifier("skyblock-preset", "test");

        Optional<StructureTemplate> test =
                world.getServer()
                        .getStructureTemplateManager()
                        .loadTemplateFromResource(structureIdentifier);

        if (test.isEmpty()) {
            SkyblockPreset.LOGGER.error("could not find :" + structureIdentifier);
            return;
        }

        var structure = test.get();

        BlockPos blockPos = new BlockPos(0, 0, 0);

        structure.place(world, blockPos, blockPos, new StructurePlacementData(), world.getRandom(), 2);
    }
}
