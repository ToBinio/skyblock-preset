package tobinio.skyblockpreset.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.screen.world.WorldScreenOptionGrid;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

@Mixin (targets = "net.minecraft.client.gui.screen.world.CreateWorldScreen$WorldTab")
public class CreateWorldScreenMixin {

    @WrapOperation (method = "<init>", at = @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$Builder;add(Lnet/minecraft/text/Text;Ljava/util/function/BooleanSupplier;Ljava/util/function/Consumer;)Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$OptionBuilder;"))
    static private WorldScreenOptionGrid.OptionBuilder init(WorldScreenOptionGrid.Builder instance, Text text,
            BooleanSupplier getter,
            Consumer<Boolean> setter,
            Operation<WorldScreenOptionGrid.OptionBuilder> original) {

        return null;
    }

    @WrapOperation (method = "<init>", at = @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$OptionBuilder;toggleable(Ljava/util/function/BooleanSupplier;)Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$OptionBuilder;"))
    static private WorldScreenOptionGrid.OptionBuilder init2(WorldScreenOptionGrid.OptionBuilder instance,
            BooleanSupplier toggleable,
            Operation<WorldScreenOptionGrid.OptionBuilder> original) {

        return null;
    }

    @WrapOperation (method = "<init>", at = @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$OptionBuilder;tooltip(Lnet/minecraft/text/Text;)Lnet/minecraft/client/gui/screen/world/WorldScreenOptionGrid$OptionBuilder;"))
    static private WorldScreenOptionGrid.OptionBuilder init3(WorldScreenOptionGrid.OptionBuilder instance, Text tooltip,
            Operation<WorldScreenOptionGrid.OptionBuilder> original) {

        return null;
    }
}
