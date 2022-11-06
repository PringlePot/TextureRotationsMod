package me.pringles.texturerotations.mixins;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {

    @Inject(method = "getRenderingSeed", at = @At("HEAD"), cancellable = true)
    private void getRenderingSeed(BlockState state, BlockPos pos, CallbackInfoReturnable<Long> cir) {
        long long1 = 8815381L;
        long long2 = 854026781L;
        long long3 = 45103847L;
        long l = (pos.getX() * long1) ^ (long)pos.getZ() * long2 ^ (long)pos.getY();
        l = l * l * long3 + l * 11L;
        cir.setReturnValue(l >> 16);
    }

}
