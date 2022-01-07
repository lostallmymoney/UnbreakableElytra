package elytraUnbreak.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(method = "isDamageable", at = @At("HEAD"), cancellable = true)
    protected void onIsDamageable(CallbackInfoReturnable<Boolean> cir){
        if (((ItemStack) (Object) this).isOf(Items.ELYTRA)) {
            cir.setReturnValue(false);
        }
    }
}