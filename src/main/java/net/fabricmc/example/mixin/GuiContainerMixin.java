package net.fabricmc.example.mixin;

import net.fabricmc.example.interfaces.AutoGetBack;
import net.minecraft.src.Container;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiContainer.class)
public abstract class GuiContainerMixin {
    @Shadow protected abstract void handleMouseClick(Slot par1Slot, int par2, int par3, int par4);
    @Shadow public Container inventorySlots;

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/src/EntityClientPlayerMP;closeScreen()V"),method = "keyTyped")
    void DoNotDrop$isShiftDown(EntityClientPlayerMP instance){
        if(this instanceof AutoGetBack) {
            ((AutoGetBack) this).DoNotDrop$GetBackIndexes().forEach((i)->{
                Slot slot = (Slot) inventorySlots.inventorySlots.get(i);
                handleMouseClick(slot,slot.slotNumber, 0, 1);
            });
        }
        instance.closeScreen();
    }
}
