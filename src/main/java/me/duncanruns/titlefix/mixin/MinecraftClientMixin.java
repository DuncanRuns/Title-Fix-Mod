package me.duncanruns.titlefix.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow
    @Final
    public InGameHud inGameHud;

    @Inject(method = "disconnect", at = @At("HEAD"))
    private void clearTitleMixin(CallbackInfo ci) {
        inGameHud.clearTitle();
        inGameHud.setDefaultTitleFade();
    }
}
