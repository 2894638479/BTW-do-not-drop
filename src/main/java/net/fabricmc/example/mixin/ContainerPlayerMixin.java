package net.fabricmc.example.mixin;

import net.minecraft.src.ContainerPlayer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ContainerPlayer.class)
public class ContainerPlayerMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/src/EntityPlayer;dropPlayerItem(Lnet/minecraft/src/ItemStack;)Lnet/minecraft/src/EntityItem;"),method = "onContainerClosed")
    EntityItem DoNotDrop$redirectDrop(EntityPlayer instance, ItemStack par1ItemStack){
        if(!instance.inventory.addItemStackToInventory(par1ItemStack)){
            return instance.dropPlayerItem(par1ItemStack);
        }
        return null;
    }
}
