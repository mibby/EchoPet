/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dsh105.echopet.compat.nms.v1_9_R1.entity.type;

import org.bukkit.DyeColor;

import com.dsh105.echopet.compat.api.entity.*;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityShulkerPet;
import com.dsh105.echopet.compat.nms.v1_9_R1.entity.EntityPet;
import com.google.common.base.Optional;

import net.minecraft.server.v1_9_R1.*;

/**
 * @Author Borlea
 * @Github https://github.com/borlea/
 * @Website http://codingforcookies.com/
 * @since Mar 7, 2016
 */

@EntitySize(width = 1.0F, height = 1.0F)
@EntityPetType(petType = PetType.SHULKER)
public class EntityShulkerPet extends EntityPet implements IEntityShulkerPet{// TODO: spawns, find a way to move it.

	protected static final DataWatcherObject<EnumDirection> ATTACHED_FACE = DataWatcher.a(EntityShulkerPet.class, DataWatcherRegistry.l);
	protected static final DataWatcherObject<Optional<BlockPosition>> ATTACHED_BLOCK_POS = DataWatcher.a(EntityShulkerPet.class, DataWatcherRegistry.k);
	protected static final DataWatcherObject<Byte> PEEK_TICK = DataWatcher.a(EntityShulkerPet.class, DataWatcherRegistry.a);// how many ticks its opened for

	public EntityShulkerPet(World world){
		super(world);
	}

	public EntityShulkerPet(World world, IPet pet){
		super(world, pet);
	}

	protected void initDatawatcher(){
		super.initDatawatcher();
		this.datawatcher.register(ATTACHED_FACE, EnumDirection.DOWN);
		this.datawatcher.register(ATTACHED_BLOCK_POS, Optional.absent());
		this.datawatcher.register(PEEK_TICK, (byte) 0);
	}

	@Override
	public SizeCategory getSizeCategory(){
		return SizeCategory.REGULAR;
	}

	@Override
	public void setOpen(boolean open){
		if(open){
			datawatcher.set(PEEK_TICK, Byte.MAX_VALUE);
		}else{
			datawatcher.set(PEEK_TICK, (byte) 0);
		}
	}

	@Override
	public void setColor(DyeColor color){}
}
