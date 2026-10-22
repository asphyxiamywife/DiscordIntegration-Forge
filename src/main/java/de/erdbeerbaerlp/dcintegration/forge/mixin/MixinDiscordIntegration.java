package de.erdbeerbaerlp.dcintegration.forge.mixin;

import de.erdbeerbaerlp.dcintegration.common.DiscordIntegration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Timer;

@Mixin(value = DiscordIntegration.class, remap = false)
public class MixinDiscordIntegration {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Timer;"), require = 1)
    private static Timer createDaemonTimer() {
        return new Timer("DiscordIntegration-Timer", true);
    }
}
