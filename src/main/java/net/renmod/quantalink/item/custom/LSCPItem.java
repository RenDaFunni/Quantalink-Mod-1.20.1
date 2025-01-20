package net.renmod.quantalink.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class LSCPItem extends Item {
    public LSCPItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = entity.getItemInHand(hand);

        if (!world.isClientSide) {
            LSCPProcedures.executeRightClick(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
        }
        // return ar;

        return InteractionResultHolder.success(itemstack);
    }
}
