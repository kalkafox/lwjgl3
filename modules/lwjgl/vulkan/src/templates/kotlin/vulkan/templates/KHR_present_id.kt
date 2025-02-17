/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package vulkan.templates

import org.lwjgl.generator.*
import vulkan.*

val KHR_present_id = "KHRPresentId".nativeClassVK("KHR_present_id", type = "device", postfix = KHR) {
    documentation =
        """
        This device extension allows an application that uses the {@link KHRSwapchain VK_KHR_swapchain} extension to provide an identifier for present operations on a swapchain. An application <b>can</b> use this to reference specific present operations in other extensions.

        

        <h5>VK_KHR_present_id</h5>
        <dl>
            <dt><b>Name String</b></dt>
            <dd>{@code VK_KHR_present_id}</dd>

            <dt><b>Extension Type</b></dt>
            <dd>Device extension</dd>

            <dt><b>Registered Extension Number</b></dt>
            <dd>295</dd>

            <dt><b>Revision</b></dt>
            <dd>1</dd>

            <dt><b>Extension and Version Dependencies</b></dt>
            <dd><ul>
                <li>Requires Vulkan 1.0</li>
                <li>Requires {@link KHRSwapchain VK_KHR_swapchain}</li>
            </ul></dd>

            <dt><b>Contact</b></dt>
            <dd><ul>
                <li>Keith Packard <a target="_blank" href="https://github.com/KhronosGroup/Vulkan-Docs/issues/new?title=VK_KHR_present_id:%20&amp;body=@keithp%20">keithp</a></li>
            </ul></dd>
        </dl>

        <h5>Other Extension Metadata</h5>
        <dl>
            <dt><b>Last Modified Date</b></dt>
            <dd>2019-05-15</dd>

            <dt><b>IP Status</b></dt>
            <dd>No known IP claims.</dd>

            <dt><b>Contributors</b></dt>
            <dd><ul>
                <li>Keith Packard, Valve</li>
                <li>Ian Elliott, Google</li>
                <li>Alon Or-bach, Samsung</li>
            </ul></dd>
        </dl>
        """

    IntConstant(
        "The extension specification version.",

        "KHR_PRESENT_ID_SPEC_VERSION".."1"
    )

    StringConstant(
        "The extension name.",

        "KHR_PRESENT_ID_EXTENSION_NAME".."VK_KHR_present_id"
    )

    EnumConstant(
        "Extends {@code VkStructureType}.",

        "STRUCTURE_TYPE_PRESENT_ID_KHR".."1000294000",
        "STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_ID_FEATURES_KHR".."1000294001"
    )
}