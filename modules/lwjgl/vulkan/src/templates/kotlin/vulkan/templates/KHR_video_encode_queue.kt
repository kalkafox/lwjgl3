/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package vulkan.templates

import org.lwjgl.generator.*
import vulkan.*

val KHR_video_encode_queue = "KHRVideoEncodeQueue".nativeClassVK("KHR_video_encode_queue", type = "device", postfix = KHR) {
    documentation =
        """
        <ul>
            <li>#CmdEncodeVideoKHR()</li>
        </ul>

        <h5>VK_KHR_video_encode_queue</h5>
        <dl>
            <dt><b>Name String</b></dt>
            <dd>{@code VK_KHR_video_encode_queue}</dd>

            <dt><b>Extension Type</b></dt>
            <dd>Device extension</dd>

            <dt><b>Registered Extension Number</b></dt>
            <dd>300</dd>

            <dt><b>Revision</b></dt>
            <dd>2</dd>

            <dt><b>Extension and Version Dependencies</b></dt>
            <dd><ul>
                <li>Requires Vulkan 1.0</li>
                <li>Requires {@link KHRVideoQueue VK_KHR_video_queue}</li>
                <li>Requires {@link KHRSynchronization2 VK_KHR_synchronization2}</li>
                <li>This is a <em>provisional</em> extension and <b>must</b> be used with caution. See the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html\#boilerplate-provisional-header">description</a> of provisional header files for enablement and stability details.</li>
            </ul></dd>

            <dt><b>Contact</b></dt>
            <dd><ul>
                <li><a target="_blank" href="mailto:ahmed.abdelkalek@amd.com">ahmed.abdelkalek@amd.com</a></li>
            </ul></dd>
        </dl>

        <h5>Other Extension Metadata</h5>
        <dl>
            <dt><b>Last Modified Date</b></dt>
            <dd>2021-03-29</dd>

            <dt><b>IP Status</b></dt>
            <dd>No known IP claims.</dd>

            <dt><b>Contributors</b></dt>
            <dd><ul>
                <li>Ahmed Abdelkhalek, AMD</li>
                <li>Damien Kessler, NVIDIA</li>
                <li>Daniel Rakos, AMD</li>
                <li>George Hao, AMD</li>
                <li>Jake Beju, AMD</li>
                <li>Peter Fang, AMD</li>
                <li>Piers Daniell, NVIDIA</li>
                <li>Srinath Kumarapuram, NVIDIA</li>
                <li>Thomas J. Meier, NVIDIA</li>
                <li>Tony Zlatinski, NVIDIA</li>
                <li>Yang Liu, AMD</li>
            </ul></dd>
        </dl>
        """

    IntConstant(
        "The extension specification version.",

        "KHR_VIDEO_ENCODE_QUEUE_SPEC_VERSION".."2"
    )

    StringConstant(
        "The extension name.",

        "KHR_VIDEO_ENCODE_QUEUE_EXTENSION_NAME".."VK_KHR_video_encode_queue"
    )

    EnumConstant(
        "Extends {@code VkPipelineStageFlagBits2KHR}.",

        "PIPELINE_STAGE_2_VIDEO_ENCODE_BIT_KHR".enum(0x08000000)
    )

    EnumConstant(
        "Extends {@code VkAccessFlagBits2KHR}.",

        "ACCESS_2_VIDEO_ENCODE_READ_BIT_KHR".enum(0x00000020),
        "ACCESS_2_VIDEO_ENCODE_WRITE_BIT_KHR".enum(0x00000040)
    )

    EnumConstant(
        "Extends {@code VkStructureType}.",

        "STRUCTURE_TYPE_VIDEO_ENCODE_INFO_KHR".."1000299000",
        "STRUCTURE_TYPE_VIDEO_ENCODE_RATE_CONTROL_INFO_KHR".."1000299001"
    )

    EnumConstant(
        "Extends {@code VkQueueFlagBits}.",

        "QUEUE_VIDEO_ENCODE_BIT_KHR".enum(0x00000040)
    )

    EnumConstant(
        "Extends {@code VkBufferUsageFlagBits}.",

        "BUFFER_USAGE_VIDEO_ENCODE_DST_BIT_KHR".enum(0x00008000),
        "BUFFER_USAGE_VIDEO_ENCODE_SRC_BIT_KHR".enum(0x00010000)
    )

    EnumConstant(
        "Extends {@code VkImageUsageFlagBits}.",

        "IMAGE_USAGE_VIDEO_ENCODE_DST_BIT_KHR".enum(0x00002000),
        "IMAGE_USAGE_VIDEO_ENCODE_SRC_BIT_KHR".enum(0x00004000),
        "IMAGE_USAGE_VIDEO_ENCODE_DPB_BIT_KHR".enum(0x00008000)
    )

    EnumConstant(
        "Extends {@code VkFormatFeatureFlagBits}.",

        "FORMAT_FEATURE_VIDEO_ENCODE_INPUT_BIT_KHR".enum(0x08000000),
        "FORMAT_FEATURE_VIDEO_ENCODE_DPB_BIT_KHR".enum(0x10000000)
    )

    EnumConstant(
        "Extends {@code VkImageLayout}.",

        "IMAGE_LAYOUT_VIDEO_ENCODE_DST_KHR".."1000299000",
        "IMAGE_LAYOUT_VIDEO_ENCODE_SRC_KHR".."1000299001",
        "IMAGE_LAYOUT_VIDEO_ENCODE_DPB_KHR".."1000299002"
    )

    EnumConstant(
        "Extends {@code VkQueryType}.",

        "QUERY_TYPE_VIDEO_ENCODE_BITSTREAM_BUFFER_RANGE_KHR".."1000299000"
    )

    EnumConstant(
        """
        VkVideoEncodeFlagBitsKHR - Video Encode Command Flags

        <h5>Description</h5>
        <ul>
            <li>#VIDEO_ENCODE_RESERVED_0_BIT_KHR The current version of the specification has reserved this value for future use.</li>
        </ul>

        <h5>See Also</h5>
        {@code VkVideoEncodeFlagsKHR}
        """,

        "VIDEO_ENCODE_DEFAULT_KHR".."0",
        "VIDEO_ENCODE_RESERVED_0_BIT_KHR".enum(0x00000001)
    )

    EnumConstant(
        """
        VkVideoEncodeRateControlFlagBitsKHR - Video Encode Rate Control Flags

        <h5>Description</h5>
        <ul>
            <li>#VIDEO_ENCODE_RESERVED_0_BIT_KHR The current version of the specification has reserved this value for future use.</li>
        </ul>

        <h5>See Also</h5>
        {@code VkVideoEncodeRateControlFlagsKHR}
        """,

        "VIDEO_ENCODE_RATE_CONTROL_DEFAULT_KHR".."0",
        "VIDEO_ENCODE_RATE_CONTROL_RESET_BIT_KHR".enum(0x00000001)
    )

    EnumConstant(
        """
        VkVideoEncodeRateControlModeFlagBitsKHR - Video encode rate control modes

        <h5>Description</h5>
        <ul>
            <li>#VIDEO_ENCODE_RATE_CONTROL_MODE_NONE_BIT_KHR for disabling rate control.</li>
            <li>#VIDEO_ENCODE_RATE_CONTROL_MODE_CBR_BIT_KHR for constant bitrate rate control mode.</li>
            <li>#VIDEO_ENCODE_RATE_CONTROL_MODE_VBR_BIT_KHR for variable bitrate rate control mode.</li>
        </ul>

        <h5>See Also</h5>
        ##VkVideoEncodeRateControlInfoKHR, {@code VkVideoEncodeRateControlModeFlagsKHR}
        """,

        "VIDEO_ENCODE_RATE_CONTROL_MODE_NONE_BIT_KHR".."0",
        "VIDEO_ENCODE_RATE_CONTROL_MODE_CBR_BIT_KHR".."1",
        "VIDEO_ENCODE_RATE_CONTROL_MODE_VBR_BIT_KHR".."2"
    )

    void(
        "CmdEncodeVideoKHR",
        """
        Encode operation for bitstream generation.

        <h5>C Specification</h5>
        To launch an encode operation that results in bitstream generation, call:

        <pre><code>
￿void vkCmdEncodeVideoKHR(
￿    VkCommandBuffer                             commandBuffer,
￿    const VkVideoEncodeInfoKHR*                 pEncodeInfo);</code></pre>

        <h5>Valid Usage (Implicit)</h5>
        <ul>
            <li>{@code commandBuffer} <b>must</b> be a valid {@code VkCommandBuffer} handle</li>
            <li>{@code pEncodeInfo} <b>must</b> be a valid pointer to a valid ##VkVideoEncodeInfoKHR structure</li>
            <li>{@code commandBuffer} <b>must</b> be in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html\#commandbuffers-lifecycle">recording state</a></li>
            <li>The {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> support encode operations</li>
            <li>This command <b>must</b> only be called outside of a render pass instance</li>
            <li>{@code commandBuffer} <b>must</b> be a primary {@code VkCommandBuffer}</li>
        </ul>

        <h5>Host Synchronization</h5>
        <ul>
            <li>Host access to the {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> be externally synchronized</li>
        </ul>

        <h5>Command Properties</h5>
        <table class="lwjgl">
            <thead><tr><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html\#VkCommandBufferLevel">Command Buffer Levels</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html\#vkCmdBeginRenderPass">Render Pass Scope</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html\#VkQueueFlagBits">Supported Queue Types</a></th></tr></thead>
            <tbody><tr><td>Primary</td><td>Outside</td><td>Encode</td></tr></tbody>
        </table>

        <h5>See Also</h5>
        ##VkVideoEncodeInfoKHR
        """,

        VkCommandBuffer("commandBuffer", "the command buffer to be filled with this function for encoding to generate a bitstream."),
        VkVideoEncodeInfoKHR.const.p("pEncodeInfo", "a pointer to a ##VkVideoEncodeInfoKHR structure.")
    )
}