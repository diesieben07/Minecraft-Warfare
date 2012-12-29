package mcwarfare.common.asm;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import cpw.mods.fml.relauncher.IClassTransformer;

public class WFTransformer implements IClassTransformer {

	@Override
	public byte[] transform(String name, byte[] bytes) {
		if (name.equals("net.minecraft.entity.EntityLiving")) {
			
			ClassReader reader = new ClassReader(bytes);
			ClassNode classNode = new ClassNode();
			reader.accept(classNode, 0);
			
			boolean hasTransformed = false;
			
			for (MethodNode method : ((List<MethodNode>)classNode.methods)) {
				if (method.name.equals("swingItem")) {
					InsnList list = new InsnList();
					list.add(new VarInsnNode(Opcodes.ALOAD, 0));
					list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "mcwarfare/common/WFEventHandler", "onLivingSwing", "(Lnet/minecraft/entity/EntityLiving;)V"));
					
					for (int i = 0; i < method.instructions.size(); i++) {
						AbstractInsnNode node = method.instructions.get(i);
						if (node.getOpcode() == Opcodes.RETURN) {
							method.instructions.insertBefore(node, list);
							hasTransformed = true;
							break;
						}
					}
				}
			}
			
			if (hasTransformed) {
				ClassWriter writer = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
				classNode.accept(writer);
				return writer.toByteArray();
			}
						
			return bytes;
		} else {
			return bytes;
		}
	}

}
