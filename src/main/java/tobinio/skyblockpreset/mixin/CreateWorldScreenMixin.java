package tobinio.skyblockpreset.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.world.GeneratorOptionsHolder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.WorldPreset;
import net.minecraft.world.gen.WorldPresets;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.OptionalLong;

@Mixin (CreateWorldScreen.class)
public abstract class CreateWorldScreenMixin {
    @Shadow
    @Final
    WorldCreator worldCreator;

    @Inject (method = "<init>", at = @At (value = "TAIL"))
    private void init(MinecraftClient client, Screen parent, GeneratorOptionsHolder generatorOptionsHolder,
            Optional<RegistryKey<WorldPreset>> defaultWorldType, OptionalLong seed, CallbackInfo ci) {
        this.worldCreator.setWorldType(new WorldCreator.WorldType(WorldCreator.getWorldPreset(generatorOptionsHolder, Optional.of(RegistryKey.of(RegistryKeys.WORLD_PRESET, new Identifier("skyblock-preset", "skyblock"))))
                .orElseGet(() -> null)));
    }
}
