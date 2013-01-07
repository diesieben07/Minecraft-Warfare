package mcwarfare.common.asm;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import cpw.mods.fml.relauncher.IClassTransformer;

public class WFTransformer implements IClassTransformer {

	@Override
	public byte[] transform(String name, byte[] bytes) {
		if (name.equals("net.minecraft.entity.player.EntityPlayer")) {
			ClassNode node = new ClassNode();
			ClassReader reader = new ClassReader(bytes);
			reader.accept(node, 0);
			
			for (MethodNode method : (List<MethodNode>)node.methods) {
				if (method.name.equals("damageEntity")) {
					method.instructions = new InsnList();
					method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
					method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
					method.instructions.add(new VarInsnNode(Opcodes.ILOAD, 2));
					method.instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "mcwarfare/common/WarfareEventHandler", "onPlayerDamage", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/util/DamageSource;I)V"));
					method.instructions.add(new InsnNode(Opcodes.RETURN));
				}
			}
			
			ClassWriter writer = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
			node.accept(writer);
			return writer.toByteArray();
		}
		
		return bytes;
	}

}
